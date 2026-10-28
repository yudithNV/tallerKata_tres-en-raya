public class TresEnRaya {
    private final char[][] tablero = new char[3][3];
    private char ultimo = ' ';

    public String jugar(int x, int y) {
        if (x < 1 || x > 3) throw new RuntimeException("X fuera del tablero");
        if (y < 1 || y > 3) throw new RuntimeException("Y fuera del tablero");
        if (tablero[y - 1][x - 1] != 0) throw new RuntimeException("Casilla ocupada");
        char jugador = proximoJugador();
        tablero[y - 1][x - 1] = jugador;
        ultimo = jugador;
        if (hayGanador(jugador)) return jugador + " gana";
        return "No hay ganador";
    }

    public char proximoJugador() {
        return ultimo == 'X' ? '+' : 'X';
    }

    private boolean hayGanador(char j) {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == j && tablero[i][1] == j && tablero[i][2] == j) return true;
            if (tablero[0][i] == j && tablero[1][i] == j && tablero[2][i] == j) return true;
        }
        return (tablero[0][0] == j && tablero[1][1] == j && tablero[2][2] == j)
            || (tablero[0][2] == j && tablero[1][1] == j && tablero[2][0] == j);
    }
}