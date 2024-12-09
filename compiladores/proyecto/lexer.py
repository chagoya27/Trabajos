import re 

##regular expressions

#For keyword [int]|[return]
#For operators[-+*/]
#For punctuation[;\,(){}]
#For identifier a-zA-Z]+[0-9]?
#For strings ([^"]*)"
#For constants
#(-?1?\d{1,9}|1\d{9}|20\d{8}|21[0-3]\d{7}|214[0-6]\d{6}|2147[0-3]\d{5}|21474[0-7]\d{4}|214748[0-2]\d{3}|2147483[0-5]\d{2}|21474836[0-3]\d|214748364[0-7])

regexIdentificadorEspecial = r"print"
regexPalabrasClave = r"int|return"
regexConstantes = r"(-?1?\d{1,9}|1\d{9}|20\d{8}|21[0-3]\d{7}|214[0-6]\d{6}|2147[0-3]\d{5}|21474[0-7]\d{4}|214748[0-2]\d{3}|2147483[0-5]\d{2}|21474836[0-3]\d|214748364[0-7])"
regexPuntuacion = r"[;\,(){}]"
regexIdentificadores = r"[a-zA-Z]+[0-9]?"
regexOperadores = r"[-+*/=]"
regexCadenas=r'"([^"]*)"'

#lists of tokens
tokensPalabrasClave=[]
tokensConstantes=[]
tokensPuntuacion=[]
tokensIdentificadores=[]
tokensOperadores=[]
tokensCadenas=[]


lineasLimpias=[] #this are the lines of the file but without blank spaces and line breaks



# remove blank spaces and line breaks
def limpiar(lineasArchivo,lineasLimpias):
    
    
    for linea in lineasArchivo:
        linea = linea.strip() 
        if (linea.replace(" ", "").replace("\n","") !=""):
            
            if("\"" in linea):
                lineasLimpias.append(linea)
            else:
                lineasLimpias.append(linea.replace(" ", "").replace("\n",""))
        #print(linea) #para ver las lineas del archivo
    return 


#pass a line of the file, save tokens in the general list and acording to a parameter defined as num is the regular expression
# that is excecute to verifier that the string match with some standart, if this happens it will keep in the respective list and
#remove the string obtaining as a result a line that not have the match and returning to the lex function 

#conforme vamos identificando los tokens le damos un sentido agregando etiquetas y entre cada etiqueta un simbolo de $
def match(elem,tokens,regex,num,i):
    #print(elem)
    lista=[]
    matches = re.finditer(regex, elem)
    cont=0
    
    for coincidencia in matches:
        
        palabra = coincidencia.group()
        
        if num==1:
            tokensPalabrasClave.append(palabra)
            if cont==0:
                lineasLimpias[i]=lineasLimpias[i].replace(palabra,palabra+'$')
                cont+=1

        elif num==2:
            tokensIdentificadores.append(palabra)
            if palabra!='print' and palabra!='printf':
                lineasLimpias[i]=lineasLimpias[i].replace(palabra,'id$')
            else:
                lineasLimpias[i]=lineasLimpias[i].replace(palabra,palabra+'$')
                
            
        elif num==3:
            tokensPuntuacion.append(palabra)
            lineasLimpias[i]=lineasLimpias[i].replace(palabra,palabra+'$')
            
        elif num==4:
            tokensConstantes.append(palabra)
            lineasLimpias[i]=lineasLimpias[i].replace(palabra,'num$')
            
        elif num==5:
            tokensOperadores.append(palabra)
            if palabra !='=':
                lineasLimpias[i]=lineasLimpias[i].replace(palabra,'x$')
            else:
                lineasLimpias[i]=lineasLimpias[i].replace(palabra,palabra+'$')
        elif num==6:
            tokensCadenas.append(palabra)
            lineasLimpias[i]=lineasLimpias[i].replace(palabra,'cad$')
        else:
            pass
        
        elem = elem.replace(palabra,"")
        tokens.append(palabra)
    return elem


#pass through all the list that contains the lines of the file sin blank spaces and line breaks, probe each regular expression
#defined, in away that  first will verify the strings, the print or printf, keywords, identifier, constant, punctuation
# and finally operators



def lex(lineasArchivo, tokens):
    
    limpiar(lineasArchivo,lineasLimpias)
    
    for i in range(len(lineasLimpias)):
        elem = lineasLimpias[i]
        elem=match(elem,tokens,regexCadenas,6,i)
        elem = match(elem,tokens,regexIdentificadorEspecial,2,i)
        elem = match(elem, tokens, regexPalabrasClave,1,i)
        elem=match(elem, tokens, regexIdentificadores,2,i)
        elem = match(elem, tokens, regexConstantes,4,i)
        elem =match(elem, tokens, regexPuntuacion,3,i)
        elem =match(elem, tokens, regexOperadores,5,i)
    
    convertirTokens(lineasLimpias)
    
    #print("Tokens de puntuacion",tokensPuntuacion)
    #print("Tokens Identificadores",tokensIdentificadores)
    #print("Tokens Operacion",tokensOperadores)
    #print("Tokens Constantes",tokensConstantes)
    #print("Tokens Palabras Claves",tokensPalabrasClave)
    #print("Tokens para cadenas :",tokensCadenas)
    return lineasLimpias
    

#sustituimos el caarcter $ por el caracter + en cada una de las lineas del archivo, le damos formato a la salida de los tokens
def convertirTokens(lineasLimpias):
    for i in range(len(lineasLimpias)):
        elem = lineasLimpias[i]
        if elem.endswith("$"): #si el ultimo elemento es $ eliminamos ya que no hay nigun simbolo a su derecha
            elem = elem[:-1]
        lineasLimpias[i] = elem.replace("$", "+")
        