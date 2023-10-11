from GestionadorPreguntas import GestionadorPreguntas
from string import Template

class Encuesta():

    def __init__(self, json_filename, umbral):
        self.json_filename = json_filename
        self.preguntas = GestionadorPreguntas(self.json_filename)
        self.categorias = self.preguntas.getCategorias()
        self.contadores = self.__crearContadores()
        self.umbral = umbral

    def __crearContadores(self):
        return {cat:0 for cat in self.categorias}

    def obtenerMejorCategoria(self):
        mejor_cat = ['Nada']
        mejor_cat_cont = 0
        for k, v in self.contadores.items():
            if v > mejor_cat_cont:
                mejor_cat_cont = v
                mejor_cat = k
        return mejor_cat

    def obtenerPorcentajeCategoria(self, cant_preguntas, resp_correctas):
        return resp_correctas / cant_preguntas * 100

    def obtenerTodosPorcentajesCategorias(self):
        porcentajes = {}
        for cat in self.categorias:
            n_preguntas_cat = self.preguntas.cantPreguntasPorCategoria(cat)
            resps_usuario_cat = self.contadores[cat]
            porcentaje_cat = self.obtenerPorcentajeCategoria(n_preguntas_cat, resps_usuario_cat)
            porcentajes.setdefault(cat, porcentaje_cat)
        return porcentajes

    def ordenarPorcentajesCategorias(self, porcentajes, descendiente=True):
        return sorted(porcentajes.items(), key=lambda x: x[1], reverse=descendiente)

    def categoriaAceptada(self, cat_porcentaje):
        return cat_porcentaje >= self.umbral

    def obtenerCategoriasAceptadas(self, cat_porcentajes):
        cat_aceptadas = []
        for cat_porcentaje in cat_porcentajes:
            if self.categoriaAceptada(cat_porcentaje[1]):
                cat_aceptadas.append(cat_porcentaje[0])
        return cat_aceptadas
        #return [cat_porcentaje for cat_porcentaje in cat_porcentajes if self.categoriaAceptada(cat_porcentaje)]

    def mostrarMejorCategoria(self):
        mejor_cat = self.obtenerMejorCategoria()
        mejor_cat_usuario = dict(cat=mejor_cat)
        t = Template('Usted mejor califica para: $cat')
        return t.substitute(mejor_cat_usuario)

    def mostrarPorcentajesCategorias(self):
        porcentajes_str = ""
        porcentajes = self.obtenerTodosPorcentajesCategorias()
        sorted_porcentajes = self.ordenarPorcentajesCategorias(porcentajes)
        for p in sorted_porcentajes:
            porcentajes_str += p[0] + ": " + str(p[1]) + "%\n"
        return porcentajes_str

    def obtenerPreguntasYRespuestas(self):
        preguntas = self.preguntas.obtenerTodasLasPreguntas()
        respuestas = self.preguntas.obtenerTodasLasRespuesta()
        return preguntas, respuestas

    def aumentarContPorCategoria(self, cat, index, respuesta):
        if self.preguntas.compararRespuestaCorrecta(cat, index, respuesta - 1):
            self.contadores[cat] += 1