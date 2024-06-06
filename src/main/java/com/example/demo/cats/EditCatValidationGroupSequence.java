package com.example.demo.cats;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence({Default.class, CatValidationGroupOne.class})
public interface EditCatValidationGroupSequence {
}
