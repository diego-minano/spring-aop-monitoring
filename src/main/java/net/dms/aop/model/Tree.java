package net.dms.aop.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder(setterPrefix = "with")
@ToString
public class Tree {
    private Long id;
}
