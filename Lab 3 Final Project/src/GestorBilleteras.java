public class GestorBilleteras {

    public void gestionar() {
        test();
    }

    private void test() {
        System.out.println("-----+++++ TEST +++++-----");
        System.out.println("CREANDO CUENTA DEFAULT");
        Usuario usuarioDefault = new Usuario();
        System.out.println(usuarioDefault);

        System.out.println("-----+++++ TEST +++++-----");
        System.out.println("CREANDO CUENTA COMPLETA");
        Usuario usuarioLlena1 = new Usuario(
                "Nako1991",
                "ASDF.123"
        );
        usuarioLlena1.addBilleteraVirtual(new BilleteraVirtual(
                new Persona(
                        "Pablo Gomez",
                        "12-41547945-9"),
                new Banco(
                        "test.Test",
                        "1234567812345678123456"),
                "Insertar API aqui"));
        System.out.println(usuarioLlena1);

        System.out.println("-----+++++ TEST +++++-----");
        System.out.println("CREANDO CLIENTE COMPLETO");
        Cliente cliente1 = new Cliente(
                new Persona(
                    "Maria Gonzales",
                        "9-26545145-10"
                ),
                new Banco(
                    "MARIA.GONZALES.MP",
                        "1122547856954785214555"
                ),
                "Regular");
        System.out.println(cliente1);

        System.out.println("-----+++++ TEST +++++-----");
        System.out.println("CREANDO COMPROBANTE COMPLETO");
//        Comprobante comprobante1 = new Comprobante(
//
//        )
    }
}
