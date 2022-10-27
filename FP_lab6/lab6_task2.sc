;;#######Implimenting Stak#########
(define (make-stak)
  `()
)

(define (push_s st v)
    (append (list v) st  )
    )

(define (pop_s st )
    (cdr st)    )


(define (pop_se st )
    (car st)    )


;;#######Implimenting Queue#########
(define (make-queue)
 (define p (cons '() '() ) )
 (cons p p)
)
;========== ==Перевірка черги на пустоту==========
(define (null-queue? q)
 (and
  (eq? (front q) (rear q)) (eq? (car (front q)) '() ))
)
;===== селектор (доступ) до першого елемента черги===
(define (front q)
 (car q)) 
;==== селектор (доступ) до останнього елемента черги ==
(define (rear q)
 (cdr q))
;========додавання нового елемента в чергу=========
(define (push q e)
 (define p (cons e '()))
 (if (null-queue? q)
  (begin (set-car! q p)
   (set-cdr! q p)
  )
  (begin
   (set-cdr! (rear q) p)
   (set-cdr! q p)
  ) ) )
;========== вилучення елемента з черги============
(define (pop q)
 (define x 0)
 (if (null-queue? q)
  'Empty    ;==== виведення повідомдення про пусту чергу
  (if (and (eq? (front q) (rear q))  (eq? '() (cdr (front q)))   )
   (begin
    (set! x (car (front q)))
    (set-car! (front q) '() )
    x ) 
   (begin
    (set! x (car (front q)))
    (set-car! q (cdr (front q)) )
    x ))))

(define (copy t); створення двох  черг
    (let ((r1 (make-queue) )(r2 (make-queue)) (a 1) )
         
         (do ((index 0 (+ index 1)))
             ((null-queue? t)  (list r1 r2)  )
             (begin  
               
               (set! a (pop t))
             
               (push r1 a)
               (push r2 a)
               
              
             )
             
             )
         
         
         )
    
    )

(define (f1 a b  ); перевірка чи рівні масиви
    
    (if (or (null-queue? a) (null-queue?  b)) 
        (and (null-queue? a) (null-queue? b))
        (let ((a2 (pop a) )
              (b2 (pop b)) )
             
            (if (= a2 b2)
                (f1 a b)
                #f))
        )
    
    )

(define (f2 v1 v2 ); маін
    ;(display (copy v1) )
    (let ( ( w1  (list->vector ( copy v1   )) )  (w2  (list->vector ( copy v2   ))   ))
         
         (if (f1 (vector-ref w1 0) (vector-ref w2 0) )
             (display (f4 (f3 (vector-ref w1 1))) )
             (display (f5 (f6 (vector-ref w1 1)) (f6 (vector-ref w2 1)) )  )
             )
         
         
         )
    
    )
(define (f3 q); черга в стек
    
    (let (( r (make-stak)  ))
         
         ( do  ((index 0 (+ index 1)))
             ((null-queue? q)  r  )
             (set! r ( push_s r (pop q)    ) )
             )
         
         
         )
    
    )

(define (f4 s); стек в чергу
    
    (let ((q (make-queue)  )  (s2 s) )
         
         (do ((index 0 (+ index 1)))
              ((null? s2)  q  )
              (begin
                 ( push q (pop_se s2 ) )
                 (set! s2 (pop_s s2) )
                 
              )
             
             )
         
         
         
         )
    
    
    )


(define (f5 a b  ); злиття двох масивів 
    
      (do ((index 0 (+ index 1)))
              ((null-queue? b)  a  )
                (push a (pop b))        
             
             )
    
    
    
    )


(define (f6 a ); під масив з відємними числами
    
    (let ((rez (make-queue)) (t 1))
             
         ( do  ((index 0 (+ index 1)))
             ((null-queue? a)  rez  )
             (begin  (set! t (pop a) )
               (if (< t 0)
                 (push rez t )
                 0
                   )
                 
                )
             )
        
        )
    
   
    
    )



( let (  (a (make-queue))
         (b (make-queue)) )
     
    (push a 10) 
    (push a -11)
    (push a 12) 
    (push a 13)
    
    
    (push b 10) 
    (push b 11)
    (push b 12) 
    (push b -13)
    
   (f2 a b)
   
   ; (display  (copy a))
)




