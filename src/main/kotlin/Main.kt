interface Dispara {
    var municion: Int
    var municionARestar: Int

    fun recarga(): Int {
        this.municion += municion
        return this.municion
    }


    //Superclase de las armas
    abstract class ArmaDeFuego(
        open var nombre: String, open var municion: Int, open var municionARestar: Int, open var tipoDeMunicion: String,
        open var danio: Int, open var radio: String
    ) {

        //Método que hace que un arma dispare y se heredará a las demás clases
        open fun dispara(): Int {
            this.municion = municion - municionARestar
            return municion
        }

        //Método que hace que un arma dispare y se heredará a las demás clases
        open fun recarga(): Int {
            this.municion += municion
            return this.municion
        }

    }

    //Subclase pistola
    class Pistola(
        override var nombre: String,
        override var municion: Int,
        override var municionARestar: Int,
        override var tipoDeMunicion: String,
        override var danio: Int,
        override var radio: String
    ) : ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio, radio) {

        //Ponemos este metodo para que al llamar al objeto salga con su nombre y no con el de la clase
        override fun toString(): String = nombre

        //A heredado el metodo dispara poniendo override delate del metodo y se a multiplicado *1 la municionARestar
        override fun dispara(): Int {
            municion = municion - (municionARestar * 1)
            return municion
        }

    }

    //Subclase Rifle
    class Rifle(
        override var nombre: String,
        override var municion: Int,
        override var municionARestar: Int,
        override var tipoDeMunicion: String,
        override var danio: Int,
        override var radio: String
    ) : ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio, radio) {
        //Ponemos este metodo para que al llamar al objeto salga con su nombre y no con el de la clase
        override fun toString(): String = nombre

        //A heredado el metodo dispara poniendo override delate del metodo y se a multiplicado *2 la municionARestar
        override fun dispara(): Int {
            this.municion = municion - (municionARestar * 2)
            return municion
        }

    }

    //Subclase Bazooka
    class Bazooka(nombre: String, municion: Int, municionARestar: Int, tipoDeMunicion: String, danio: Int, radio: String
    ) : ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio, radio) {
        //Ponemos este metodo para que al llamar al objeto salga con su nombre y no con el de la clase
        override fun toString(): String = nombre

        //A heredado el metodo dispara poniendo override delate del metodo y se a multiplicado *3 la municionARestar
        override fun dispara(): Int {
            this.municion = municion - (municionARestar * 3)
            return municion
        }
    }

    class casa(var tipo: String, var direccion: String, var codigoPostal: Int, override var municion: Int, override var municionARestar: Int) : Dispara {

        override fun toString(): String {
            return tipo
        }
    }

    class bocadillo(var tipo: String, var ingredientes: String, var salsa: String, override var municion: Int, override var municionARestar: Int) : Dispara {

        override fun toString(): String {
            return tipo
        }
    }

    class coche(var marca: String, var caballos: Int, var color: String, override var municion: Int, override var municionARestar: Int) : Dispara {

        override fun toString(): String {
            return marca
        }
    }

fun main() {
    //Instancio 6 objetos, cada uno de una subclase distinta
     var Rk9: Pistola = Pistola("Rk9", 15, 1, "9mm", 2, "Pqueño")
     var AK47: Rifle = Rifle("AK47", 30, 3, "11mm", 3, "Amplio")
     var RPG: Bazooka = Bazooka("RPG", 15, 1, "Explosiva", 10, "Amplio")
     var casa1: casa = casa("Apartamento", "Avenida los milagros", 11204, 35, 4)
     var bocadilloTortilla: bocadillo = bocadillo("Bocadillo tortilla", "Pan, tortilla y pimiento", "Mayonesa", 40, 2)
     var Mustang: coche = coche("Ford Mustang",240, "negro", 33, 2)

     var listaArma = listOf(Rk9, RPG, AK47, casa1, bocadilloTortilla, Mustang)
     var mapaAleatorio = mutableMapOf<Int, ArmaDeFuego>()

     //Se crea un bucle para que las armas disparen de forma aleatoria
     for (i in 1..6) {
         var random = (0..5).random()
         mapaAleatorio.put(i, listaArma[random] as ArmaDeFuego)
        }
     //Imprime los objetos seleccionados de forma aleatoria que van a disparar
     for (it in mapaAleatorio) {
          println("${it.value}")

        }
        println()
     //Se imprimen por pantalla los objetos que disparan y cuantas veces de forma aleatoria
     for (i in 1..6) {
         println("${mapaAleatorio.get(i)?.nombre} a disparado = ${mapaAleatorio.get(i)?.dispara()}")
        }


    }
}