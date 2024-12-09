class Pila:
    def init(elemento):
        elemento.items = []

    def vacia(self):
        return self.items == []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        if not self.esta_vacia():
            return self.items.pop()

    def ver_tope(self):
        if not self.esta_vacia():
            return self.items[-1]
        
        


# Ejemplo de uso
mi_pila = Pila()
mi_pila.push(mi_pila,1)


print("Tope de la pila:", mi_pila.ver_tope())  # Output: 3

while not mi_pila.vacia():
    print("Desapilando:", mi_pila.pop())