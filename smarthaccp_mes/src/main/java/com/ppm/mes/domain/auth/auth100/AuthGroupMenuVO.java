package com.ppm.mes.domain.auth.auth100;

import java.util.List;

import com.ppm.mes.domain.pgm.pgm000.Program;

import lombok.Data;

@Data
public class AuthGroupMenuVO {
    private List<AuthGroupMenu> list;
    private Program program;
}
