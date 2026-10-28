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
        return "";
    }

    public char proximoJugador() {
        return ultimo == 'X' ? '+' : 'X';
    }
}