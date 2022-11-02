
;========= символьне диференціювання====
(define (variable? x) (symbol? x))
(define (same-variable? v1 v2)
  (and (variable? v1) (variable? v2) (eq? v1 v2)))

(define (make-sum a1 a2) (list '+ a1 a2))



(define (make-product m1 m2) (list '* m1 m2))

(define (make-devide m1 m2) (list '/ m1 m2))




(define (sum? x)
  (and (pair? x) (eq? (car x) '+)))

(define (minus? x)
  (and (pair? x) (eq? (car x) '-)))

(define (make-minus a1 a2) (list '- a1 a2))

(define (addend s) (cadr s))
(define (augend s) (caddr s))

(define (product? x)
  (and (pair? x) (eq? (car x) '*)))

(define (devide? x)
  (and (pair? x) (eq? (car x) '/)))


(define (multiplier p) (cadr p))
(define (multiplicand p) (caddr p))


(define (cos? x)
  (and (pair? x) (eq? (car x) 'cos)))

(define (make-cos a1 a2 ) (list `*  (list `* -1 a2) (list 'sin a1)   )  )



(define (sin? x)
  (and (pair? x) (eq? (car x) 'sin)))

(define (make-sin a1 a2 ) (list `*  a2 (list 'cos a1)   )  )




(define (tg? x)
  (and (pair? x) (eq? (car x) 'tg)))

(define (make-tg a1 a2 ) (list `*  a2 (list '/ 1 (  list `*  (list 'cos a1) (list 'cos a1) )  )   )  )



(define (ctg? x)
  (and (pair? x) (eq? (car x) 'ctg)))

(define (make-ctg a1 a2 ) (list `*  a2 (list '/ -1 (  list `*  (list 'sin a1) (list 'sin a1) )  )   )  )



(define (deriv exp var)
  (cond ((number? exp) 0)
    ((variable? exp)
     (if (same-variable? exp var) 1 0))
    ((sum? exp)
     (make-sum (deriv (addend exp) var)
               (deriv (augend exp) var)))
           
     ((minus? exp)
     (make-minus (deriv (addend exp) var)
               (deriv (augend exp) var))) 
      
           
           
    ((product? exp)
     (make-sum
       (make-product (multiplier exp)
                     (deriv (multiplicand exp) var))
       (make-product (deriv (multiplier exp) var)
                     (multiplicand exp))))
                 
    ((devide? exp)
    ( make-devide         
     (make-minus
         
       (make-product (deriv (multiplier exp) var)
                     (multiplicand exp)) 
         
       (make-product (multiplier exp)
                     (deriv (multiplicand exp) var))
          )  (make-product (multiplicand exp)  (multiplicand exp)  )   )  )
                 
    
     ((cos? exp)
     (make-cos   (addend exp)  (deriv (addend exp) var)     ) 
     )
    
     ((sin? exp)
     (make-sin   (addend exp)  (deriv (addend exp) var)     ) 
     )
 
    ((tg? exp)
     (make-tg   (addend exp)  (deriv (addend exp) var)     ) 
     )
    
    ((ctg? exp)
     (make-ctg   (addend exp)  (deriv (addend exp) var)     ) 
     )
 
 
                 
    (else
     (display "unknown expression type - DERIV" ))))

(display (deriv '(ctg (* 5 x) ) 'x ))
(deriv '3 'x)
(deriv '(* x y) 'x)
(deriv '(! x y) 'x)