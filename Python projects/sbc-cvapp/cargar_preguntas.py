import json

JSON_FILE = 'Preguntas copy.json'  # Archivo JSON con las preguntas

def cargar_preguntas(JSON_FILE=JSON_FILE, cat='Generales'):
    preguntas = None
    with open(JSON_FILE) as json_data:
        preguntas = json.load(json_data)
    return preguntas[cat][0]

cargar_preguntas()