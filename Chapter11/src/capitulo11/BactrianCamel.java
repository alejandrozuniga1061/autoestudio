package capitulo11;

import java.io.FileNotFoundException;

public class BactrianCamel extends Camel {
	public int getNumberOfHumps() throws  IllegalArgumentException{ // DOES NOT COMPILE
		return 2;
	}
}
