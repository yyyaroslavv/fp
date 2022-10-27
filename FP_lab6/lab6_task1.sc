

;===========сума елементів вектора=================
(define vector-sum-abs
  (lambda (vec)
    (let ((len (vector-length vec))
          (result 0))        
      (do ((index 0 (+ index 1)))
          ((= index len) result)
        (set! result (+ result ( abs (vector-ref vec index))))))))


(define (f3 vec t a); кількість входження числа до т елемента
    (let ((summ1 0))
         (do ((index 0 (+ index 1)))
             ((= index t) summ1   )
             (if (= a (vector-ref vec index))
                 
             (set! summ1 (+ summ1 1))
                         5)
                 )
             )
        
        )
    
   


(define (f2 vec stop t n) ; створення списку списків (кількість разів зустрічі елмента перший індекс значення елементу)  
    
    (if (= t n)
        `()
        (if (= stop (vector-ref vec t))
             (f2 vec stop (+ t 1) n)
             (let 
                  (( a (vector-ref vec t))
                   ( summ1  0  ))
               ;==========================
               
               ;========================
                 (do ((index t (+ index 1)))
                     ((= index n) 
                      (if (= 0  (f3 vec t a)  )
                          (cons (list  summ1 t a  ) (f2 vec stop (+ t 1) n ))
                      (f2 vec stop (+ t 1) n )
                      
                      )
                       )
                     ( if (= a (vector-ref vec index) )
                       (set! summ1 (+ summ1 1))
                         5)
                     )
                 
                 
                 )
             
             )
        
        )
    
    
    )


(define (f5  a b a1 a2); повернення найбільшого елмента (індекс)
   
    (if (<  (vector-ref(list->vector a) 0) (vector-ref(list->vector b) 0) )
        a2
        a1
        )
    
    
    )

(define ( f1 vec); повертає найбіш зустрічаємий елемент
  
  
  ( let 
    ((  vec2  (list->vector (f2 vec (+(vector-sum-abs vec) 1) 0 (vector-length vec)  )) )
       (a 0)  )
   (display  vec2 )
   (newline)
   (do ((index 0 (+ index 1)))
        ((= index  (vector-length vec2) ) (vector-ref vec2 a) )
        (set! a (f5 (vector-ref vec2 a) (vector-ref vec2 index)   a index  ) )
       )
   
   )
    )

(newline)

(let
(( m (f1 '#(3 3 -7 -7 -7 9 9 9 9))))
(display "максимум ")
(display m) 

)