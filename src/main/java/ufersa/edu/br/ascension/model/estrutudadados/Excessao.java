/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufersa.edu.br.ascension.model.estrutudadados;

public class Excessao extends RuntimeException {
	private static final long serialVersionUID = 4652958143051993454L;

	private String description = "";
	
	public Excessao(String description)
	{
        super(description);
        
        this.description = description;
    }
	
	public String getDescription() {
		return description;
	}
}
