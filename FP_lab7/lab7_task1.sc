;====== запис рядків у файл==============

(define (read_file path  )
    
   (apply string (file->char_list path ))
    )

(define (file->char_list path)
 (call-with-input-file path
   (lambda (input-port)
     (let loop ((x (read-char input-port)))
       (cond 
        ((eof-object? x) '())
        (#t (begin (cons x (loop (read-char input-port))))))))))

;===============================






;Записати кожне речення тексту в порядку зростання кількості голосних букв в ;слові.
(define T (quote("hello mrs." "aaaaaaaaa" "what are you doing?" "bbbbbbbbbbbb" "good bye.")))
;============= визначити голосні ===================
(define (isVowelChar char)  
  (cond ((eq? char #\e) 1)	
        ((eq? char #\y) 1)
        ((eq? char #\u) 1)
        ((eq? char #\i) 1)
        ((eq? char #\o) 1)
        ((eq? char #\a) 1)
        (else 0)
  ))
;===========порахувати кількість голосних ==============
 (define (vowelCount sentence)
  (if(> (length sentence) 0)
  (+ (isVowelChar (car sentence)) (vowelCount(cdr sentence)))
  0)
 )
;===============знайти слово з максимальною кількістю голосних==
(define (maxVowelSentence word sentence)
  (if (not(null? sentence))
      (if(< (string-length  word)  ( string-length  (car sentence) ))
         (maxVowelSentence word (cdr sentence))
         (maxVowelSentence (car sentence) (cdr sentence))
         )
      word
  ) 
 )
;==========видалити елемент зі списку===================
(define delete
  (lambda (item list)
    (cond
     ((equal? item (car list)) (cdr list))
     (else (cons (car list) (delete item (cdr list)))))
))
;===========сортування слів по кількооті голосних======================
(define (sortText text)
  (if (not(null? text))
      (cons (maxVowelSentence (car text) (cdr text))
            (sortText (delete (maxVowelSentence (car text) (cdr text)) text)))
        `()
  )
)




(define (get-end-list  vec  s )
    (define ( asd a end vec s )
        
        
        ( if (= a end)
          `()
           (if ( eq? (vector-ref vec a)  s)
                 (cons a (asd (+ a 1) end vec s  ) )
                 ( asd (+ a 1) end vec s )
                 )
    )
        )
    
    (asd 0 (vector-length vec) vec s )
     )



(define (asd3  vec a b )
    
   (if (= a b)
        `()
    (cons (vector-ref vec a)  (asd3 vec (+ a 1) b  )    )    
    
    )
    
    )

(define (sentense vec l)
    
        (define (asd2  vec l a) 
            
            (if (null? l ) 
                `()
                (cons  (asd3 vec (+ a 1)  (car l)  )  (asd2 vec (cdr l) (car l) )    )
                )
            
            )
        
    (asd2 vec l -1 )
    
    )



(define (f2 v s )
    
    (append (get-end-list   v s   )  (list ( vector-length  v )) )
    
    )





(define (list-str l)
     (if (null? l ) 
    `()
   (cons (list->string (car l)) (list-str (cdr l))  )
     )
    )


(define (clear l)
    
    (if ((string=? (car l) "."))
        `()
        ( cons  (car l)  (clear (cdr l))   )
        )
    
    )



(define (concat l )
    
    (if (null? l)
     ". "    
    (string-append (string-append(car l) " ") (concat(cdr l)) ) 
    )
    )


(define (f3 l) 
    
    
    (if (null? l)  
     `""
     
     (begin (let ((be 5)  ( vec (list->vector (cdr(car l))))   )
   
      (set! be (f2   vec   #\   ) )
      
     
      
      (string-append (concat  (sortText (list-str (sentense vec be)))) (f3 (cdr l))   )
      
          )
      ))
    )

(define (f1 l )
    
     (let ((be 5)  ( vec (list->vector (car l)))   )
   
      (set! be (f2   vec   #\   ) )
      
      
      ( string-append (concat (sortText (list-str ( sentense vec be))))  (f3 (cdr l))  ) 
      
          )
    
  
    
    )






(let ((port (open-output-file "/myfiles/ff1.txt"))) 
; в імені не припустимі пробіли та кирілицю
(write '(When I find myself in times of trouble. ) port)
(write '(Mother Mary  comes to me. ) port)
(write '(Speaking words of wisdom, "Let it be.") port)

(close-output-port port))
;"/uploads/f1.txt"

( let
  ((vec (string->vector (read_file "/myfiles/ff1.txt")) ) (be 5)    )

(set! be (get-end-list   vec  #\.  )   )

(set! be  (f1 ( sentense vec be)   ) )



(let ((port (open-output-file "/myfiles/ff2.txt"))) 
; в імені не припустимі пробіли та кирілицю
(write be port)

(close-output-port port))


)
