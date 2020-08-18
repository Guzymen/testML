# testML
Test for MercadoLibre

Realizados los niveles 1 y 2.
URL de la app: http://testmercadolibre-env.eba-v5tmqshf.sa-east-1.elasticbeanstalk.com/

Instrucciones:
Servicio creado /mutant/.
Enviar http post a la url http://testmercadolibre-env.eba-v5tmqshf.sa-east-1.elasticbeanstalk.com/mutant/ un json, que simula una matriz de adn, con el siguiente formato para validar el adn:
{"dna":["ATCG","ATCG","ATCG","ATCG"]}
Ejemplos de posibilidades:
3 secuencias:
{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
0 secuencias:
{
"dna":["CTGCTA","CAGTGC","TTATGT","AGAAGG","ACCCTA","TCACTG"]
}
Secuencia vertical:
{
"dna":["CTGCGA","CAGTGC","TTATGT","AGAAGG","ACCCTA","TCACTG"]
}
Secuencia horizontal:
{
"dna":["CTGCTA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
Secuencia diagonal:
{
"dna":["ATGCTA","CAGTGC","TTATGT","AGAAGG","ACCCTA","TCACTG"]
}