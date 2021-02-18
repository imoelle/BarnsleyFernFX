BarnsleyFernFX

From Wikipedia, the free encyclopedia (https://en.wikipedia.org/wiki/Barnsley_fern)

The Barnsley fern is a fractal named after the British mathematician Michael Barnsley who first described it in his book Fractals Everywhere.

Contents

    1 History
    2 Construction
        2.1 Computer generation
        2.2 Mutant varieties

History

The fern is one of the basic examples of self-similar sets, i.e. it is a mathematically generated pattern that can be reproducible at any 
magnification or reduction. Like the Sierpinski triangle, the Barnsley fern shows how graphically beautiful structures can be built from 
repetitive uses of mathematical formulas with computers. Barnsley's 1988 book Fractals Everywhere is based on the course which he taught 
for undergraduate and graduate students in the School of Mathematics, Georgia Institute of Technology, called Fractal Geometry. After 
publishing the book, a second course was developed, called Fractal Measure Theory.[1] Barnsley's work has been a source of inspiration 
to graphic artists attempting to imitate nature with mathematical models.

Barnsley fern plotted with Processing
Barnsley fern plotted with Processing

The fern code developed by Barnsley is an example of an iterated function system (IFS) to create a fractal. This follows from the collage 
theorem. He has used fractals to model a diverse range of phenomena in science and technology, but most specifically plant structures.

    IFSs provide models for certain plants, leaves, and ferns, by virtue of the self-similarity which often occurs in branching structures 
    in nature. But nature also exhibits randomness and variation from one level to the next; no two ferns are exactly alike, and the branching 
    fronds become leaves at a smaller scale. V-variable fractals allow for such randomness and variability across scales, while at the same time 
    admitting a continuous dependence on parameters which facilitates geometrical modelling. These factors allow us to make the hybrid biological 
    models... ...we speculate that when a V -variable geometrical fractal model is found that has a good match to the geometry of a given plant, 
    then there is a specific relationship between these code trees and the information stored in the genes of the plant.

Construction
Real lady ferns.

Barnsley's fern uses four affine transformations. The formula for one transformation is the following:

    f ( x , y )     =   [ a b ] [ x ]   +   [ e ] 
                        [ c d ] [ y ]       [ f ] 

Barnsley shows the IFS code for his Black Spleenwort fern fractal as a matrix of values shown in a table.[3] In the table, the columns "a" through "f" 
are the coefficients of the equation, and "p" represents the probability factor.
    w 	    a 	    b 	    c 	    d 	    e 	    f 	    p 	    Portion generated
    ƒ1 	    0 	    0 	    0 	    0.16 	0 	    0 	    0.01 	Stem
    ƒ2 	    0.85 	0.04 	−0.04 	0.85 	0 	    1.60 	0.85 	Successively smaller leaflets
    ƒ3 	    0.20 	−0.26 	0.23 	0.22 	0 	    1.60 	0.07 	Largest left-hand leaflet
    ƒ4 	    −0.15 	0.28 	0.26 	0.24 	0 	    0.44 	0.07 	Largest right-hand leaflet

These correspond to the following transformations:

    f 1 ( x , y )   =   [ 0.00   0.00 ] [ x ]
                        [ 0.00   0.16 ] [ y ]

    f 2 ( x , y )   =   [  0.85   0.04 ] [ x ] + [ 0.00 ]
                        [− 0.04   0.85 ] [ y ]   [ 1.60 ]

    f 3 ( x , y )   =   [ 0.20   -0.26 ] [ x ] + [ 0.00 ]
                        [ 0.23    0.22 ] [ y ]   [ 1.60 ]

    f 4 ( x , y )   =   [ -0.15  0.28 ] [ x ] + [ 0.00 ]
                        [  0.26  0.24 ] [ y ]   [ 0.44 ]
Computer generation
System-search.svg
	
This section's factual accuracy is disputed. Relevant discussion may be found on Talk:Barnsley fern. Please help to ensure that disputed statements 
are reliably sourced. (May 2020) (Learn how and when to remove this template message) Fractal fern in four states of construction. Highlighted triangles 
show how the half of one leaflet is transformed to half of one whole leaf or frond.

Though Barnsley's fern could in theory be plotted by hand with a pen and graph paper, the number of iterations necessary runs into the tens of thousands, 
which makes use of a computer practically mandatory. Many different computer models of Barnsley's fern are popular with contemporary mathematicians. 
As long as the math is programmed correctly using Barnsley's matrix of constants, the same fern shape will be produced.

The first point drawn is at the origin (x0 = 0, y0 = 0) and then the new points are iteratively computed by randomly applying one of the following 
four coordinate transformations:[4][5]

ƒ1

    xn + 1 = 0

    yn + 1 = 0.16 yn.

This coordinate transformation is chosen 1% of the time and just maps any point to a point in the first line segment at the base of the stem. This 
part of the figure is the first to be completed during the course of iterations.


ƒ2

    xn + 1 = 0.85 xn + 0.04 yn

    yn + 1 = −0.04 xn + 0.85 yn + 1.6.

This coordinate transformation is chosen 85% of the time and maps any point inside the leaflet represented by the red triangle to a point inside 
the opposite, smaller leaflet represented by the blue triangle in the figure.

ƒ3

    xn + 1 = 0.2 xn − 0.26 yn

    yn + 1 = 0.23 xn + 0.22 yn + 1.6.

This coordinate transformation is chosen 7% of the time and maps any point inside the leaflet (or pinna) represented by the blue triangle to a 
point inside the alternating corresponding triangle across the stem (it flips it).

ƒ4

    xn + 1 = −0.15 xn + 0.28 yn

    yn + 1 = 0.26 xn + 0.24 yn + 0.44.

This coordinate transformation is chosen 7% of the time and maps any point inside the leaflet (or pinna) represented by the blue triangle to a 
point inside the alternating corresponding triangle across the stem (without flipping it).

The first coordinate transformation draws the stem. The second generates successive copies of the stem and bottom fronds to make the complete 
fern. The third draws the bottom frond on the left. The fourth draws the bottom frond on the right. The recursive nature of the IFS guarantees 
that the whole is a larger replica of each frond. Note that the complete fern is within the range −2.1820 < x < 2.6558 and 0 ≤ y < 9.9983.

Mutant varieties
Barnsley fern mutated into a Thelypteridaceae fern.
Barnsley fern mutated into a leptosporangiate fern.

By playing with the coefficients, it is possible to create mutant fern varieties. In his paper on V-variable fractals, Barnsley calls this 
trait a superfractal.[2]

One experimenter has come up with a table of coefficients to produce another remarkably naturally looking fern however, resembling the Cyclosorus or Thelypteridaceae fern. These are:[6][7]
w 	    a 	    b 	    c 	    d       e 	    f 	    p
ƒ1 	    0 	    0    	0 	    0.25 	0 	    −0.4 	0.02
ƒ2 	    0.95 	0.005 	−0.005 	0.93 	−0.002 	0.5 	0.84
ƒ3 	    0.035 	−0.2 	0.16 	0.04 	−0.09 	0.02 	0.07
ƒ4 	    −0.04 	0.2 	0.16 	0.04 	0.083 	0.12 	0.07