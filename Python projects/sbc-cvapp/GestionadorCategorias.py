class GestionadorCategorias:
    """
    
    """
    def __init__(self):
        self.contadores = {
            "front": 0,
            "back": 0,
            "full": 0,
            "dev_ops": 0,
            "qa": 0,
            "ux": 0,
        }

    def aumentarCategoria(self, nombre=None):
        self.contadores[nombre] += 1
    
    def getCategoria(self)
