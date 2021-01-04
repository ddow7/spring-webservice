package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA 엔티티 클래스가 BaseTime 엔티티를 상속할 경우 필드들도 칼럼으로 인식하게 함
@EntityListeners(AuditingEntityListener.class) // BaseTime 엔티티에 Auditing 기능 포함
public class BaseTimeEntity {
    @CreatedDate // 엔티티가 생성되어 저장될 때 시간이 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 엔티티의 값을 변경할 때 시간이 자동 저장
    private LocalDateTime modifiedDate;
}
