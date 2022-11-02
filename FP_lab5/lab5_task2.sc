(define (numer x) (car x)); дійсна та уявна частина
(define (denom x) (cdr x))	


(define (print-rat x)			; друк пари 
  (newline)
  (display (numer x))
  (display "  i")
  (display (denom x)))


(define (make-from-mag-ang r a); побудова числа за радіусом та кутом
(cons (* r (cos a)) (* r (sin a))))


(define (len-ang r a );коли дан кут та радіус
    
    
    (cons (make-from-mag-ang r a) (make-from-mag-ang (* -1 r) a) )
    (display " точки \n")
    (print-rat  ( make-from-mag-ang r a  ) )
    
    (print-rat  ( make-from-mag-ang (* -1 ) a  ) )
    
    )

(define (beem a); коли дан кут
    
    (display "\n пряма що проходе через точки \n")
     (print-rat  ( make-from-mag-ang 1 a  ) )
      (print-rat  ( make-from-mag-ang 0 a  ) )
    )

(define (circle z ); коли дан радіус
    
    
    (display "\n коло з центром в точці 0 0 та радіусом ")
     (display z)
    
    )


( len-ang 1 0.4  )

(beem 0.3)

(circle 1 )