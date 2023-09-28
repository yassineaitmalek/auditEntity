package com.test.auditEntity.dto.audit;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommitMetadata {

  private String author;

  private List<String> properties;

  private LocalDateTime commitDate;

  private LocalDateTime commitDateInstant;

  private Float id;

}
