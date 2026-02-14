package com.bootcamp.week1;

public class ManipuladorStrings {
	
	public static StringBuilder invertir(String s) {
        // TODO: usar StringBuilder.reverse()
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		//String reversedStr = sb.toString();
        return sb;
    }

	public static boolean esPalindromo(String s) {
	    s = s.trim().toLowerCase();
	    s = s.replaceAll(":", "");

	    StringBuilder invertido = new StringBuilder(s);
	    String reversa = invertido.reverse().toString();

	    return s.equals(reversa);
	}

    public static int contarVocales(String s) {
        int count = 0;
        String vocales = "aeiouAEIOU";
        // TODO: recorrer cada caracter, verificar si es vocal
        for (int i = 0 ; i < s.length(); i++) { 
        	char letra = s.charAt(i);
        	if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o'|| letra == 'u') { 
        		count ++;
        	}
        }
        return count;
    }

    public static String construirPiramide(int niveles) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= niveles; i++) {
            // TODO: agregar espacios (niveles - i)
        	//for (int j = niveles - i; j > 0; j--) {
        	//	sb.append(" ");
        	//}
            // TODO: agregar asteriscos (2*i - 1)
        	//for (int j = 0; j < 2 * i - 1 ; j++) {
        	//	sb.append("*");
        	//}
           sb.append(" ".repeat(niveles - i));
           sb.append("*".repeat(2 * i - 1));
        	
        	sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Invertir 'Hola Mundo': "
                         + invertir("Hola Mundo"));
        System.out.println("'Anita lava la tina' es palindromo: "
                         + esPalindromo("Anita lava la tina"));
        System.out.println("Vocales en 'Murcielago': "
                         + contarVocales("Murcielago"));
        System.out.println("Piramide de 5 niveles:");
        System.out.println(construirPiramide(5));
    }

}
