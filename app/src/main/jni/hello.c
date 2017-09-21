#include <jni.h>
#include <string.h>
/*
 * Class:     com_cxria_ndkapplication_MainActivity
 * Method:    add
 * Signature: (DD)Ljava/lang/String;
 */
  char *string;
  double value;
  int dec, sign;
  int ndig = 10;

JNIEXPORT jdouble JNICALL Java_com_cxria_ndkapplication_MainActivity_add
  (JNIEnv * env, jclass obj, jdouble number1, jdouble number2){
    jdouble add=number1+number2;
    return add;

  }

  /*
   * Class:     com_cxria_ndkapplication_MainActivity
   * Method:    minus
   * Signature: (DD)Ljava/lang/String;
   */
  JNIEXPORT jdouble JNICALL Java_com_cxria_ndkapplication_MainActivity_minus
  (JNIEnv * env, jclass obj, jdouble number1, jdouble number2){
  jdouble minus=number1-number2;
  return minus;
  }

  /*
   * Class:     com_cxria_ndkapplication_MainActivity
   * Method:    multiply
   * Signature: (DD)Ljava/lang/String;
   */
  JNIEXPORT jdouble JNICALL Java_com_cxria_ndkapplication_MainActivity_multiply
  (JNIEnv * env, jclass obj, jdouble number1, jdouble number2){
    jdouble multiply=number1*number2;
     return multiply;

    }

  /*
   * Class:     com_cxria_ndkapplication_MainActivity
   * Method:    divide
   * Signature: (DD)Ljava/lang/String;
   */
  JNIEXPORT jdouble JNICALL Java_com_cxria_ndkapplication_MainActivity_divide
  (JNIEnv * env, jclass obj, jdouble number1, jdouble number2){
    jdouble divide=number1/number2;
    return divide;

    }
