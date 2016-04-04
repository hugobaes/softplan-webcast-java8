package br.com.hugobaes.softplan.webcast.lambda;

interface BlocoSimples 
{
    void funcao();
}

interface BlocoGenerico<RETORNO, PARAMETRO>
{
    RETORNO funcao(PARAMETRO parametro);
}

interface BlocoGenerico2Argumentos<RETORNO, PARAMETRO1, PARAMETRO2>
{
    RETORNO funcao(PARAMETRO1 parametro1, PARAMETRO2 parametro2);
}

