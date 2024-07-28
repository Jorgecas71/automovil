package dev.jorge.enums;

public enum CarType {
   CITY_CAR, SUBCOMPACT, COMPACT, FAMILY, EXECUTIVE, SUV;

   @Override
   public String toString() {
      return "CarType: " + name();
   }
}