import json
class GestionadorPreguntas:
    """Realiza carga de preguntas en un archivo JSON y gestiona sus
    accesos

    cargar_preguntas(self, cat='Generales') - carga las preguntas del
    archivo JSON indicado en la variable de instancia 'json_filename'.
    Retorna un diccionario con las preguntas y sus respuestas.
    """

    def __init__(self, json_filename):
        self.json_filename = json_filename
        self.preguntas = self.__cargar_preguntas()
    
    def __cargar_preguntas(self):
        preguntas = None
        with open(self.json_filename) as json_data:
            preguntas = json.load(json_data)
        return preguntas
    
    def obtenerTodasLasPreguntas(self):
        preguntas = []
        for cat in list(self.preguntas):
            for i in range(len(self.preguntas[cat])):
                preguntas.append(self.preguntas[cat][i]['Pregunta'])
        return preguntas

    def obtenerTodasLasRespuesta(self):
        respuestas = []
        for cat in list(self.preguntas):
            for i in range(len(self.preguntas[cat])):
                for j in range(len(self.preguntas[cat][i]['Respuestas'])):
                    respuestas.append(self.preguntas[cat][i]["Respuestas"][j]["Respuesta"])
        return respuestas

    def getPreguntaPorIndice(self, cat, ix=0):
        return self.preguntas[cat][ix]["Pregunta"]

    def getPreguntasPorCategoria(self, cat):
        return [pregunta["Pregunta"] for pregunta in self.preguntas[cat]]

    def getRespuestasPorCategoria(self, cat):
        resp_cat = []
        for pregunta in self.preguntas[cat]:
            for respuestas in pregunta['Respuestas']:
                resp_cat.append(respuestas['Respuesta'])
        return resp_cat

    def mostrarRespuestaDePreguntaPorIndice(self, cat, ix=0):
        respuestas = [str(ix) + ") " + r['Respuesta']
        for ix, r in enumerate(self.preguntas[cat][ix]["Respuestas"], start=1)]
        return '\n'.join(respuestas)
    
    def getRespuestaDePreguntaPorIndice(self, cat, preg_ix, resp_ix):
        return self.preguntas[cat][preg_ix]["Respuestas"][resp_ix]["Respuesta"]

    def getCategorias(self):
        return list(self.preguntas)

    def compararRespuestaCorrecta(self, cat, ix=0, r_usuario=0):
       return self.preguntas[cat][int(ix)]["Respuestas"][int(r_usuario)]["Valor"] == 1

    def cantPreguntasPorCategoria(self, cat):
        return len(self.preguntas[cat])