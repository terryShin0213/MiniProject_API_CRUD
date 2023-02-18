package com.blog.common.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.Instant;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
  @CreatedDate
  private Instant createdDate;

  @CreatedBy
  private String createdBy;

  @LastModifiedDate
  private Instant modifiedDate;

  @LastModifiedBy
  private String modifiedBy;

  private Boolean deleted;
}
