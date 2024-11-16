package com.accessbank.ingressmsspringboot.example.scope;

import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor(staticName = "createNewComputer")
@FieldDefaults(level = PRIVATE)
@RequiredArgsConstructor(staticName = "createComp")
public class  Computer {
     final String mark;
      float price;
}
