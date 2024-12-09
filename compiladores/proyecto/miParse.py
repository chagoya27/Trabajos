#definimos la gramatica como un diccionario de un arreglo de arreglos
grammar = {
    'S': [['return', 'I'], ['int', 'F'], ['id', 'A'], ['print', 'E']],
    'A': [['(', 'M'], [';'], ['=', 'I']],
    'B': [[';'], ['x', 'H']],
    'C': [['num', 'B']],
    'E': [['(', 'J']],
    'F': [['id', 'A']],
    'G': [[';'], ['x', 'H']],
    'H': [['num', 'B'], ['id', 'G']],
    'I': [['-', 'C'], ['id', 'G'], ['num', 'B']],
    'J': [['cad','K']],
    'K': [[')', 'L']],
    'L': [[';']],
    'M': [['num', 'N'], ['id','N']  ],
    'N': [[')', 'O'], [',','M'] ],
    'O': [[';'], ['{']]
}

#diccionario que almacena el First 
first={}


#diccionario que almacena el Follow 
follow={}

#diccionario que representa la table parse
parseTable={}

#estructura de lista que representará una pila
pila=[]

#para los {}
pilaE=['$']

#obtenemos los noTerminales y las producciones de la gramatica y las pasamos para construir los First
def contruccion():
    for noTerminal,producciones in grammar.items():
            #print(noTerminal,produccion)
            construccionFirst(noTerminal,producciones)



#recorremos las producciones de cada uno de los no terminales, dada la gramatica el elemento 0 de cada produccion es el first
#guardamos los first en una lista para al final asignar en un diccionario el no terminal con su correspondiente lista de FIRST

def construccionFirst(noTerminal,producciones):
    listaTerminales=[]
    for produccion in producciones: 
        listaTerminales.append(produccion[0])
    first[noTerminal]=listaTerminales



    
#genera la representacion de la tabla de parse
#donde cada terminal sera un diccionario de listas cada lista tendra un caracter al inicio representando el no terminal
#y una lista que reprenta a la produccion generada
# se veria de esta forma Terminal: [noTerminal,produccion]
def construccionParseTable(grammar,first):
    contador=0
    for noTerminal,listaelem in first.items():
        for elem in listaelem:
            contador=0
            listaListas = grammar[noTerminal]
            for lista in listaListas:
                    if elem in lista:
                        generacion = listaListas[contador]
                        if elem in parseTable:
                            parseTable[elem].append([noTerminal,generacion])
                        else:
                            parseTable[elem] = [[noTerminal,generacion]]
                    contador+=1


#Identifica en base a la pila principal y la pilaE si existe algun error en el codigo
#si la pila tiene por tope el caracter "$" no hay ningun error
def errores(pila,aux,buffer):
    if len(pila)<1:
        return False
    
    ultimoElem = pila.pop()

    
    if ultimoElem == '$': 
        if aux==1:
            tope = pilaE.pop()
            if tope=='$':
                return True
            else:
                print("Error: Hace falta cerrar el caracter {")
                return False
        return True
    else:
        if ultimoElem =='S':
            print("No es posible iniciar una linea con el caracter",buffer[0])
            
        if ultimoElem=='E':
            print("Caracter despues de print no valido, se espera ()")
        
        if ultimoElem =='I':
            print("Caracter despues de return no valido, se espera algun identificador o numero")
        
        if ultimoElem =='A':
            if buffer[-2]!=';':
                print("Falta colocar ; al final de la linea")
            else:
                print('Despues del identificador se esperan los caracteres = o ()')
        
        if ultimoElem=='F':
            print("Caracter despues de int no valido, se espera un identificador o una variable")

        if ultimoElem =='B':
            if buffer[-2]!=';':
                print("Falta colocar ; al final de la linea")
        
        if ultimoElem == 'H':
            print("No se pueden tener dos operadores de forma consecutiva hace falta un operando")
        
        if ultimoElem == 'M':
            print("Hace falta colocar un elemento dentro de () o cerrar el parentesis")
        
        if ultimoElem == 'O':
            if buffer[-2]!=';':
                print("Falta colocar ; al final de la linea")
            else:
                print("No puede haber ningun elemento despues del caracter )")
        
        if ultimoElem == 'K':
            print("Falta cerrar parentesis de print")
        
        return  False


def parse(lineasTokens):
    aux=0 #para verificar cuando se esta en la ultima linea
    error=0 #para llevar un control y mostrar el mensaje de cadena aceptada
    contruccion()
    construccionParseTable(grammar,first)
    for i in range(len(lineasTokens)):
        
        elem = lineasTokens[i]
        buffer = elem.split('+')
        buffer.append("$")
        print(buffer) #para ver la linea que se esta analizando
            
        pila.append("$")
        pila.append("S")
        
        generacionParse(pila,buffer,0,parseTable)
        
        if i == len(lineasTokens)-1: #si llegamos al tope del archivo
            aux=1
        
        if errores(pila,aux,buffer) == False:
            error=1
            print("Cadena rechazada")
            break
    if error==0:   
        print("Cadena aceptada")


def generacionParse(pila,buffer,i,parseTable):
    
    print(pila) #para ver lo movimientos de la pila
    
    luckAhead = buffer[i]
    #print("luckAhead",luckAhead)
    #condicion de salida cuando se llega al ultimo caracter $
    
    if luckAhead=='$':
            return 
    
    if luckAhead in parseTable:
        generaciones=parseTable[luckAhead]
        
        for generacion in generaciones:
            if len(pila)>0:
                    if pila[-1] == generacion[0]:
                        numElementos = len(generacion[1])
                        pila.pop()
                        while numElementos>0:
                            pila.append(generacion[1][numElementos-1])
                            numElementos=numElementos-1
                        print(pila) #con esto vemos la pila despues de una generacion
                        
                        if luckAhead == '{':
                            pilaE.append('{')
                            
    if luckAhead=='}': #si lo que vemos es un caracter de }
        pilaE.pop() #removemos el ultimo elemento de la pila E y si este es un { entonces todo esta bien y quitamos un noTerminal de la pila principal
        if pila[-1]=="S":
            pila.pop()
            
        
    

        #si lo que estamos viendo en buffer es lo que esta hasta arriba de la pila removemos el elemento de la pila y llamamos recursivamente
    if len(pila)>0:
        if pila[-1] == luckAhead:        
            pila.pop()
            i+=1
            generacionParse(pila,buffer,i,parseTable)
    
    
    
    
    



def imprimirDiccionario(diccionario):
    for noTerminal,produccion in diccionario.items():
        print(noTerminal,produccion)