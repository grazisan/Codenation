package challenge;

public class CriptografiaCesariana implements Criptografia {

    String alfabeto = "abcdefghijklmnopqrstuvwxyz";
    String result = "";

    private boolean validaTexto() {
        return validaTexto();
    }

    private boolean validaTexto(String texto){
        if (texto == null)
            throw new NullPointerException("Texto nulo");

         if(texto.length() == 0)
            throw new IllegalArgumentException("Texto vazio");

    }

    @Override
    public String criptografar(String texto) {
        texto = texto.toLowerCase();

        for(int i= 0; i<texto.length(); i++) {

            int posicao = alfabeto.indexOf(texto.charAt(i));
            int nPosicao = posicao + 3;
            char letra = 0;

            if (Character.isWhitespace(texto.charAt(i)) ) {
                result = result + " ";
            }else if(Character.isDigit(texto.charAt(i)) ){
                result = result + texto.charAt(i);
            }else if(posicao > 25){
                letra = alfabeto.charAt(posicao - 23);
                result = result +letra;
            }else{
                letra = alfabeto.charAt(nPosicao);
                result = result + letra;
            }
        }
        return result;
    }

    @Override
    public String descriptografar(String texto) {
        texto = texto.toLowerCase();

        for(int i= 0; i<texto.length(); i++) {

            int posicao = alfabeto.indexOf(texto.charAt(i));
            int nPosicao = posicao - 3;
            char letra = 0;

            if (Character.isWhitespace(texto.charAt(i)) ) {
                result = result + " ";
            }else if(Character.isDigit(texto.charAt(i)) ) {
                result = result + texto.charAt(i);
            }else if (posicao < 0) {
                letra = alfabeto.charAt(posicao + 23);
                result = result + letra;
            }else {
                 letra = alfabeto.charAt(nPosicao);
                result = result + letra;
            }
        }

        return result;
    }
}
