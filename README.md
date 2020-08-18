# testML
Test for MercadoLibre

Realizados los niveles 1 , 2 y 3.

URL de la app: http://testmercadolibre-env.eba-v5tmqshf.sa-east-1.elasticbeanstalk.com/

Instrucciones:

Servicios creados:
/mutant/ (POST).
/stats (GET).

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

Enviar http get a la url http://testmercadolibre-env.eba-v5tmqshf.sa-east-1.elasticbeanstalk.com/stats , la aplicación devolverá las estadísticas de los adns analizados con el siguiente formato:
{
    "ratio”": 0.5,
    "count_human_dna": 12,
    "count_mutant_dna": 6
}