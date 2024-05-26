import java.awt.Dimension;
import java.awt.Point;

public class MyPoint extends Point{

		private Dimension size;
		private int direccionPoint;
		private boolean antepenultima;
		private boolean penultima;


		public MyPoint(Dimension size, int x, int y, int direccionPoint) {
			super(x,y);
			this.size=size;
			this.direccionPoint=direccionPoint;
			antepenultima=false;
			penultima=false;
		}

		public MyPoint(Dimension size, int x, int y) {
			super(x,y);
			this.size=size;
		}

		public MyPoint(int x, int y) {
			super(x,y);
		}

		public void setSize(Dimension size) {
			this.size=size;
		}

		public Dimension getSize() {
			return this.size;
		}

		public int getWidth() {
			return (int)this.size.getWidth();
		}

		public int getHeight() {
			return (int)this.size.getHeight();
		}

		public int getDireccionPoint() {
			return this.direccionPoint;
		}

		public void setantePenultima(boolean antepenultima) {
			this.antepenultima=antepenultima;
		}

		public boolean isantePenultima() {
			return antepenultima;
		}

		public void setPenultima(boolean penultima) {
			this.penultima=penultima;
		}

		public boolean isPenultima() {
			return this.penultima;
		}

	}
