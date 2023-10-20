package com.api.fleetManagement.cli;


import com.api.fleetManagement.service.ReadFile;

public class Cli {

        public static void main(String[] args) {
            if (args.length < 1) {
                System.out.println("Uso: MyCLI opciones:\n--help [Todos los comandos]\n"+
                        "--readFile [Leer el archivo]\n" + "--loadData [subir archivos a base de datos]\n"
                         );
                System.exit(1);
            }

            String comando = args[0];

            if ("--read".equals(comando)) {
                if (args.length > 1) {
                    String path = args[1];
                    String file = ReadFile.readFile(path);
                    System.out.println("Contenido del archivo: ");
                    System.out.println(file);
                } else {
                    System.out.println("Archivo no encontrado");
                }
            } else if ("--help".equals(comando)) {
                System.out.println("Uso: MyCLI --read [archivo] - Para ver el contenido del archivo");
                System.out.println("  MyCLI --help - Mostrar esta ayuda");
            } else {
                System.out.println("Comando no reconocido. Usa 'MyCLI --help' para ver la ayuda.");
            }
        }

}
