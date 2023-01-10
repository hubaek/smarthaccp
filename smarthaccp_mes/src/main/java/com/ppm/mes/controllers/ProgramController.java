package com.ppm.mes.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.pgm.pgm000.Program;
import com.ppm.mes.domain.pgm.pgm000.ProgramService;

/*
 * 프로그램관리
 */
@Controller
@RequestMapping(value = "/api/v1/programs")
public class ProgramController extends BaseController {

    @Inject
    private ProgramService programService;

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse list(RequestParams<Program> requestParams) {
        List<Program> programs = programService.get(requestParams);
        return Responses.ListResponse.of(programs);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public ApiResponse save(@Valid @RequestBody List<Program> request) {
        programService.saveProgram(request);
        return ok();
    }
}
