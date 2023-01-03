package net.dms.aop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tree {
    private Long id;
}
