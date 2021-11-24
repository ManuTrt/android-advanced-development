package com.manu.data;

public interface Mapper<P, R>{
    R map(P model);
}
