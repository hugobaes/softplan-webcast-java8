package br.com.hugobaes.softplan.webcast.lambda;

interface BlocoSimples 
{
    void funcao();
}

interface BlocoGenerico<PARAMETRO, RETORNO>
{
    RETORNO funcao(PARAMETRO parametro);
}

interface BlocoGenerico2Argumentos<PARAMETRO1, PARAMETRO2, RETORNO>
{
    RETORNO funcao(PARAMETRO1 parametro1, PARAMETRO2 parametro2);
}

