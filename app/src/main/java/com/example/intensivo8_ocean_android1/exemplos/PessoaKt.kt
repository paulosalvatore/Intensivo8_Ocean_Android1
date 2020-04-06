package com.example.intensivo8_ocean_android1.exemplos

data class PessoaKt(val nome: String,
                    val sobrenome: String,
                    val idade: Int? = null,
                    val mae: PessoaKt? = null) {

    fun exibirNome() {
        println("$nome $sobrenome")
    }
}

// PessoaKt -> Classe - Representa qualquer pessoa
// paulo ou o andre -> Objetos dessa classe - represetam uma pessoa específica

fun main () {

    val pessoa = PessoaKt(
        nome = "Nome Mãe",
        sobrenome = "Sobrenome Mãe"
    )

    val paulo = PessoaKt(
        nome = "Paulo",
        sobrenome = "Salvatore",
        mae = pessoa
    )
    val andre =
        PessoaKt("André", "Atoji")

    println("A pessoa chama-se ${andre.nome}")

    println("A mãe da pessoa chama-se ${paulo.mae?.nome}")
    println("A mãe da pessoa chama-se ${andre.mae?.nome}")
    // A mãe da pessoa chama-se null

    andre.mae?.let {
        println("A mãe da pessoa chama-se ${it.nome}")
    }
}
