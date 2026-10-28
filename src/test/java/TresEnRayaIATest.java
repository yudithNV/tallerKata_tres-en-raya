import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TresEnRayaIATest {

    private TresEnRaya juego;

    @BeforeEach
    void setUp() {
        juego = new TresEnRaya();
    }

    // Requerimiento 1: Colocación de piezas

    @Test
    void debeLanzarExcepcionCuandoXEsMenorQueUno() {
        // Arrange
        int x = 0;
        int y = 1;

        // Act + Assert
        assertThrows(RuntimeException.class, () -> juego.jugar(x, y));
    }

    @Test
    void debeLanzarExcepcionCuandoXEsMayorQueTres() {
        // Arrange
        int x = 4;
        int y = 1;

        // Act + Assert
        assertThrows(RuntimeException.class, () -> juego.jugar(x, y));
    }

    @Test
    void debeLanzarExcepcionCuandoYEsMenorQueUno() {
        // Arrange
        int x = 1;
        int y = 0;

        // Act + Assert
        assertThrows(RuntimeException.class, () -> juego.jugar(x, y));
    }

    @Test
    void debeLanzarExcepcionCuandoYEsMayorQueTres() {
        // Arrange
        int x = 1;
        int y = 4;

        // Act + Assert
        assertThrows(RuntimeException.class, () -> juego.jugar(x, y));
    }

    @Test
    void debeLanzarExcepcionCuandoLaCasillaEstaOcupada() {
        // Arrange
        juego.jugar(1, 1);

        // Act + Assert
        assertThrows(RuntimeException.class, () -> juego.jugar(1, 1));
    }

    // Requerimiento 2: Turnos de los jugadores

    @Test
    void elPrimerJugadorDebeSerX() {
        // Arrange
        juego = new TresEnRaya();

        // Act
        char jugador = juego.proximoJugador();

        // Assert
        assertEquals('X', jugador);
    }

    @Test
    void despuesDeJugarXDebeSeguirElJugadorMas() {
        // Arrange
        juego = new TresEnRaya();

        // Act
        juego.jugar(1, 1);
        char jugador = juego.proximoJugador();

        // Assert
        assertEquals('+', jugador);
    }

    @Test
    void despuesDeJugarMasDebeSeguirElJugadorX() {
        // Arrange
        juego = new TresEnRaya();

        // Act
        juego.jugar(1, 1);
        juego.jugar(2, 1);
        char jugador = juego.proximoJugador();

        // Assert
        assertEquals('X', jugador);
    }

    // Requerimiento 3: Condiciones de victoria

    @Test
    void noDebeHaberGanadorCuandoNoExisteUnaLineaCompleta() {
        // Arrange
        juego.jugar(1, 1);
        juego.jugar(2, 1);

        // Act
        String resultado = juego.jugar(3, 2);

        // Assert
        assertEquals("No hay ganador", resultado);
    }

    @Test
    void debeGanarXCuandoCompletaUnaLineaHorizontal() {
        // Arrange
        juego.jugar(1, 1);
        juego.jugar(1, 2);
        juego.jugar(2, 1);
        juego.jugar(2, 2);

        // Act
        String resultado = juego.jugar(3, 1);

        // Assert
        assertEquals("X gana", resultado);
    }

    @Test
    void debeGanarXCuandoCompletaUnaLineaVertical() {
        // Arrange
        juego.jugar(1, 1);
        juego.jugar(2, 1);
        juego.jugar(1, 2);
        juego.jugar(2, 2);

        // Act
        String resultado = juego.jugar(1, 3);

        // Assert
        assertEquals("X gana", resultado);
    }

    @Test
    void debeGanarXCuandoCompletaUnaDiagonalPrincipal() {
        // Arrange
        juego.jugar(1, 1);
        juego.jugar(1, 2);
        juego.jugar(2, 2);
        juego.jugar(1, 3);

        // Act
        String resultado = juego.jugar(3, 3);

        // Assert
        assertEquals("X gana", resultado);
    }

    @Test
    void debeGanarXCuandoCompletaUnaDiagonalSecundaria() {
        // Arrange
        juego.jugar(1, 3);
        juego.jugar(1, 1);
        juego.jugar(2, 2);
        juego.jugar(2, 1);

        // Act
        String resultado = juego.jugar(3, 1);

        // Assert
        assertEquals("X gana", resultado);
    }

    @Test
    void debeGanarMasCuandoCompletaUnaLineaHorizontal() {
        // Arrange
        juego.jugar(1, 1);
        juego.jugar(1, 2);
        juego.jugar(2, 1);
        juego.jugar(2, 2);
        juego.jugar(3, 3);

        // Act
        String resultado = juego.jugar(3, 2);

        // Assert
        assertEquals("+ gana", resultado);
    }
}