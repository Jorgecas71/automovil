package dev.jorge.enums;

public enum Color {
     WHITE, BLACK, RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET;

     @Override
     public String toString() {
          return "Color: " + name();
     }
}