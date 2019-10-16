/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author Administrador
 */
public class RepException extends RuntimeException {

	public RepException() {
		super();
	}

	public RepException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepException(String message) {
		super(message);
	}

	public RepException(Throwable cause) {
		super(cause);
	}
}
