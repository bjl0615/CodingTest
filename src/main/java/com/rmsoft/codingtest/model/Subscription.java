package com.rmsoft.codingtest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {

    private String username; // 사용자 ID

    private int numberOfUsers; // 사용 인원

    private SubType serviceType; // 서비스 구독 형태

    private double storageCapacity; // 스토리지 용량

    private double useStorageCapacity; // 스토리지 사용량

    private double remainStorageCapacity; // 남은 스토리지 용량

    private int subscriptionPeriod; // 구독 기간

    private String companyName; // 회사 이름

    private String phoneNumber; // 전화 번호

    private String email; // 이메일

    private String address; // 주소
}
