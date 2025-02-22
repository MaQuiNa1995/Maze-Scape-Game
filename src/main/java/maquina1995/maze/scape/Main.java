package maquina1995.maze.scape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main extends JFrame implements KeyListener {
	private char[][] nivel1;
	private int jugadorX;
	private int jugadorY;

	public Main() {
		setTitle("Laberinto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 800);
		setVisible(true);
		addKeyListener(this);

		// Definimos el mapa del laberinto con intenciones de meter mas en un futuro o
		// incluso hacerle procedural
		nivel1 = new char[][] {
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
				{ '#', 'E', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#' },
				{ '#', ' ', '#', '#', '#', ' ', '#', ' ', ' ', '#' },
				{ '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#' },
				{ '#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#' },
				{ '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#' },
				{ '#', ' ', '#', '#', '#', ' ', '#', ' ', ' ', '#' },
				{ '#', ' ', '#', 'S', '#', ' ', '#', ' ', '#', '#' },
				{ '#', ' ', '#', ' ', '#', '#', '#', ' ', ' ', '#' },
				{ '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#' },
				{ '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' }
		};

		// Inicializar la posici�n del jugador
		for (int y = 0; y < nivel1.length; y++) {
			for (int x = 0; x < nivel1[0].length; x++) {
				if (nivel1[y][x] == 'E') {
					jugadorX = x;
					jugadorY = y;
					break;
				}
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// Obtenemos la anchura y altura del mapa y lo dividimos equitativamente entre
		// las casillas del laberinto para que quede uniforme
		int anchoCasilla = getWidth() / nivel1[0].length;
		int altoCasilla = getHeight() / nivel1.length;

		// Recorremos las casillas para pintarlas en pantalla segun el caracter que
		// tenga
		for (int y = 0; y < nivel1.length; y++) {
			for (int x = 0; x < nivel1[0].length; x++) {

				// obtenemos 1 a 1 las casillas
				char casilla = nivel1[y][x];
				// conseguimos las posiciones x, y de las mismas
				int xPos = x * anchoCasilla;
				int yPos = y * altoCasilla;

				// Dependiendo el caracter lo pintamos de 1 color y lo pintamos como cuadrado
				if (casilla == '#') {
					g.setColor(Color.BLACK);
					g.fillRect(xPos, yPos, anchoCasilla, altoCasilla);
				} else if (casilla == 'E') {
					g.setColor(Color.GREEN);
					g.fillRect(xPos, yPos, anchoCasilla, altoCasilla);
				} else if (casilla == 'S') {
					g.setColor(Color.RED);
					g.fillRect(xPos, yPos, anchoCasilla, altoCasilla);
				} else if (x == jugadorX && y == jugadorY) {
					// En este caso para el jugador usamos un circulo
					g.setColor(Color.BLUE);
					g.fillOval(xPos, yPos, anchoCasilla, altoCasilla);
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		// obtenemos la tecla pulsada
		int keyCode = e.getKeyCode();
		int nuevaX = jugadorX;
		int nuevaY = jugadorY;

		// Dependiendo sumaremos o restaremos a X o Y
		if (keyCode == KeyEvent.VK_W) {
			nuevaY--;
		} else if (keyCode == KeyEvent.VK_S) {
			nuevaY++;
		} else if (keyCode == KeyEvent.VK_A) {
			nuevaX--;
		} else if (keyCode == KeyEvent.VK_D) {
			nuevaX++;
		}
		// Controlamos que no se salga del mapa ni pueda atravesar paredes
		if (nuevaX >= 0 && nuevaX < nivel1[0].length && nuevaY >= 0 && nuevaY < nivel1.length
				&& nivel1[nuevaY][nuevaX] != '#') {

			// Controlamos condicion de victoria
			if (nivel1[nuevaY][nuevaX] == 'S') {
				JOptionPane.showMessageDialog(null, "Has ganado !", "Game over", JOptionPane.INFORMATION_MESSAGE);
			}

			// Ponemos a vac�a la posicion antigua del jugador
			nivel1[jugadorY][jugadorX] = ' ';

			// Actualizamos las coordenadas del jugador
			jugadorX = nuevaX;
			jugadorY = nuevaY;

			// Ahora que hemos movido al jugador actualizamos en el mapa su posici�n
			nivel1[jugadorY][jugadorX] = 'J';
			repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Main());
	}
}