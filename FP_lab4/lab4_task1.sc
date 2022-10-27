
(define (my-length lis)
   (cond ((null? lis)
          0)
         (else
          (+ 1 (my-length (cdr lis))))))




(define (my-list-ref items n) 
     (if (= n 1) 
         (car items)
         (my-list-ref (cdr items) (- n 1 ))))
     
(define (fib2 n a b)
            (if (= n 0)
                `()
                (append ( list (+ a b)) (fib2 (- n 1) (+ a b) a )  )
                )
            )    
     
(define (fib n l )
    
    (if (null? l)
        (append (list 1 1) (fib2 (- n 2) 1 1 )  )
        (append l  (fib2 n (my-list-ref l ( - (my-length l) 0 )  )  (my-list-ref l ( - (my-length l) 1 )  )   ))
        
        )

    
    )     
     

(display (fib 10 (list 6 7 8 9 3) )    )