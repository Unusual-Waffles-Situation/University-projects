from GestionadorPreguntas import GestionadorPreguntas

JSON_FILENAME = 'Preguntas_Generales.json'
UMBRAL_ACEPTACION = 50

def crearContadores(categorias):
    return {cat:0 for cat in categorias}

def obtenerMejorCategoria(contadores):
    mejor_cat = ['Nada']
    mejor_cat_cont = 0
    for k, v in contadores.items():
        if v > mejor_cat_cont:
            mejor_cat_cont = v
            mejor_cat = k
    return mejor_cat

def obtenerPorcentajeCategoria(cant_preguntas, resp_correctas):
    return resp_correctas / cant_preguntas * 100

def obtenerTodosPorcentajesCategorias(preguntas, categorias, contadores):
    porcentajes = {}
    for cat in categorias:
        n_preguntas_cat = preguntas.cantPreguntasPorCategoria(cat)
        resps_usuario_cat = contadores[cat]
        porcentaje_cat = obtenerPorcentajeCategoria(n_preguntas_cat, resps_usuario_cat)
        porcentajes.setdefault(cat, porcentaje_cat)
    return porcentajes

def ordenarPorcentajesCategorias(porcentajes, descendiente=True):
    return sorted(porcentajes.items(), key=lambda x: x[1], reverse=descendiente)

def mostrarMejorCategoria(contadores):
    mejor_cat = obtenerMejorCategoria(contadores)
    mejor_cat_usuario = dict(cat=mejor_cat)
    t = Template('Usted mejor califica para: $cat')
    return t.substitute(mejor_cat_usuario)

def mostrarPorcentajesCategorias(preguntas, categorias, contadores):
    porcentajes_str = ""
    porcentajes = obtenerTodosPorcentajesCategorias(preguntas, categorias, contadores)
    sorted_porcentajes = ordenarPorcentajesCategorias(porcentajes)
    for p in sorted_porcentajes:
        porcentajes_str += p[0] + ": " + str(p[1]) + "%\n"
    return porcentajes_str

def aumentarContPorCategoria(cat, index, respuesta):
    if p_generales.compararRespuestaCorrecta(cat, index, respuesta - 1):
        contadores[cat] += 1

def categoriaAceptada(cat_porcentaje):
    return cat_porcentaje >= UMBRAL_ACEPTACION

def obtenerCategoriasAceptadas(cat_porcentajes):
    #cat_aceptadas = []
    #for cat_porcentaje in cat_porcentajes:
    #    if categoriaAceptada(cat_porcentaje):
    #        cat_aceptadas.append(cat_porcentaje)
    #return cat_aceptadas
    return [cat_porcentaje for cat_porcentaje in cat_aceptadas if categoriaAceptada(cat_porcentaje)]

preguntas = GestionadorPreguntas(JSON_FILENAME)
categorias = p_generales.getCategorias()
contadores = crearContadores(categorias)