package com.test.auditEntity.dto.audit;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditDB<T> {

  private CommitMetadata commitMetadata;

  private GlobalID globalId;

  private T state;

  private List<String> changedProperties;

  private String type;

  private Long version;

  public static List<String> header() {

    return Arrays.asList(
        "author", "properties", "commitDate", "commitDateInstant", "id",
        "entity", "cdoId",
        "state",
        "changedProperties", "type", "version"

    );

  }

}
