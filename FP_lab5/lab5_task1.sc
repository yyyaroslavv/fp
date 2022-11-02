(define (numer x) (car x))			;чисельник
(define (denom x) (cdr x))		;знаменник
(define (make-rat n d) (cons n d))		; створення пари
(define(print-rat x)			; друк пари 
  (newline)
  (display (numer x))
  (display "/")
  (display (denom x)))

(define (add-rat x y)
      (make-rat (+ (* (numer x) (denom y)
                    )
                   (* (numer y) (denom x)
                    )
                 )
                 (* (denom x) (denom y)
                 )
       )
    )
 
;===========віднімання дробив===============
(define (sub-rat x y)
       (make-rat (- (* (numer x) (denom y))
                             (* (numer y) (denom x)))
                          (* (denom x) (denom y))))
                      
(define (sum lis) ;сума дробів
(define (sum2 lis acc)
   (cond ((null? lis)
            acc)
         (else
          (sum2 (cdr lis) (add-rat (car lis) acc))   ) )
)
 
    (sum2 lis (make-rat 0 1))
            
) 
(define (f1 d_c_m)
    
   ( cond ( (> d_c_m 0) 
            "кави більше")
       ((< d_c_m 0)
         "молока більше"
       )
       (else 
       "порівну"
       )
       
       )
    
    
    )



(list 1 2 3 4 5) 		; виклк процедур
( display  ( f1 (  numer ( sub-rat  (make-rat 1 1)  (sum (list (make-rat 1 6) (make-rat 1 3) (make-rat 1 2)   ))))))
