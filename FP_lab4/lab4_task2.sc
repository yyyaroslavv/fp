(define (my-length lis) 
   (cond ((null? lis)
          0)
         (else
          (+ 1 (my-length (cdr lis))))))




(define (my-list-ref items n) 
     (if (= n 1) 
         (car items)
         (my-list-ref (cdr items) (- n 1 ))))
     
(define (fib2 n a b); прорахунок значень в послідовності фібоначі 
            (if (= n 0)
                `()
                (append ( list (+ a b)) (fib2 (- n 1) (+ a b) a )  )
                )
            )    
     
(define (fib n l ) ; початкові значення фібоначі
    
    (if (null? l)
        (append (list 1 1) (fib2 (- n 2) 1 1 )  )
        (append l  (fib2 n (my-list-ref l ( - (my-length l) 0 )  )  (my-list-ref l ( - (my-length l) 1 )  )   ))
        
        )

    
    )     
   
(define (f1 b m n acc ) ; зробити спрінт та повернути залишок задач   

    (if (= n 0)
        (begin
        (display "acc sprint =")
        (display  acc)
         (newline)
        (cons b m)
        )        
        ( begin 
        
          (newline)
        (display "------------------------------- \n" )
          (display "priotity:" )
           (display (car m) )
            (display " \n exemple: " )
             (display (car b) )
         (display "\n ------------------------------- \n" )
          (f1 (cdr b) (cdr m) (- n 1)  (+ acc (car m)) )
            )
        )    
    )   
   

(define (f2 b m n); виконання бедлогу
          (display " \n ============================== \n sprint \n =================================================   ")
        (let ((a (min (my-length b) n)))
            (if (= a 0)
                0
               (let ((n-m (f1 b m a 0)  ))
                     (f2 (car n-m) (cdr n-m) n )                 
                   
                   )
                )
            
            
            )
    
    
    )


(f2 (list 1 2 3 4 5)  (fib 5 `() ) 2 )   