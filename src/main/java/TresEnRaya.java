public class TresEnRaya {
    // 1. Declaramos el tablero de 3x3 para guardar las fichas
    private final char[][] tablero = new char[3][3];

    public String jugar(int x, int y) {
        if (x < 1 || x > 3) throw new RuntimeException("X fuera del tablero");
        if (y < 1 || y > 3) throw new RuntimeException("Y fuera del tablero");
        
        // 2. Validamos si la casilla ya está ocupada (si es diferente de 0)
        if (tablero[y - 1][x - 1] != 0) throw new RuntimeException("Casilla ocupada");
        
        // 3. Guardamos la jugada en el tablero (por ahora fija como 'X')
        tablero[y - 1][x - 1] = 'X';

        return "";
    }
}