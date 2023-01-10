package com.ppm.mes.domain.pgm.pgm000;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.chequer.axboot.core.utils.TemplateUtils;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.auth.auth100.AuthGroupMenu;
import com.ppm.mes.domain.auth.auth100.AuthGroupMenuService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAUpdateClause;

@Service
public class ProgramService extends BaseService<Program, String> {

    private ProgramRepository repository;

    @Inject private AuthGroupMenuService authGroupMenuService;

    @Inject
    public ProgramService(ProgramRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Program> get(RequestParams<Program> requestParams) { 
        String filter = requestParams.getFilter();

        BooleanBuilder builder = new BooleanBuilder();

        List list = select().from(qProgram).where(builder).orderBy(qProgram.progNm.asc()).fetch();

        if (isNotEmpty(filter)) {
            list = filter(list, filter);
        }

        return list;
    }

    @Transactional
    public void saveProgram(List<Program> programs) {
        for (Program program : programs) {

            // 삭제 처리 
            if (program.isDeleted()) {
                List<String> menuCodes = select().select(qMenu.menuCd).distinct().from(qMenu).where(qMenu.progCd.eq(program.getProgCd())).fetch();
                delete(qAuthGroupMenu).where(qAuthGroupMenu.menuCd.in(menuCodes)).execute();
                update(qMenu).setNull(qMenu.progCd).where(qMenu.progCd.eq(program.getProgCd())).execute();

                delete(program.getId());
            }

            // 저장 처리
            else {
                TemplateUtils.makeJspAndJsFiles(program.getProgPh());

                // 신규 저장일 경우
                if (isEmpty(program.getProgCd())) {
                    program.setProgCd(FilenameUtils.getBaseName(program.getProgPh()));
                    save(program);

                } else {
                    // 신규 저장이 아닐 경우

                    List<String> menuCodes = select().select(qMenu.menuCd).distinct().from(qMenu).where(qMenu.progCd.eq(program.getProgCd())).fetch();
                    List<AuthGroupMenu> authGroupMenuList = select().select(qAuthGroupMenu).from(qAuthGroupMenu).where(qAuthGroupMenu.menuCd.in(menuCodes)).fetch();

                    // 해당 프로그램으로 권한 그룹이 등록된 경우 권한을 다시 설정 (Y -> N로 변경된 항목만 체크)
                    if (isNotEmpty(authGroupMenuList)) {
                        for (AuthGroupMenu authGroupMenu : authGroupMenuList) {
                            authGroupMenu.updateAuthorization(program);
                            authGroupMenuService.save(authGroupMenu);
                        }
                    }

                    Program existProgram = findOne(program.getId());

                    // 프로그램 코드가 변경되었을 경우
                    if (notEquals(existProgram.getProgPh(), program.getProgPh())) {
                        program.setProgCd(FilenameUtils.getBaseName(program.getProgPh()));

                        delete(existProgram.getId());

                        // 메뉴에 메뉴코드 & 프로그램코드 변경
                        new JPAUpdateClause(em, qMenu)
                                .set(qMenu.progCd, program.getProgCd())
                                .where(qMenu.progCd.eq(existProgram.getProgCd()))
                                .execute();
                    }
                    save(program);
                }
            }
        }
    }
}
