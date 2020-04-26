package Flat;

import Shared.Flat;

import java.util.List;

public interface FlatDAO {
    List<Flat> getAll();
    List<Flat> getAll(String option , String value);
    String toString();
}
