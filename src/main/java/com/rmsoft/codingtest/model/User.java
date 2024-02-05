package com.rmsoft.codingtest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String username; // 사용자 ID

    private String password; // 비밀번호

    private String email; // 이메일

    private RoleType role; // 유저 OR 관리자

    private Timestamp createDate; // 생성 일시
}
