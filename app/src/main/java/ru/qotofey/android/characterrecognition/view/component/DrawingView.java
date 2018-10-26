package ru.qotofey.android.characterrecognition.view.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class DrawingView extends View {

    //смещение, необходимое для продолжения рисования
    private static final float TOUCH_TOLERANCE = 10;

    private Bitmap mBitmap;             //область рисования для вывода или сохранения
    private Canvas mBitmapCanvas;       //используется для рисования на Bitmap
    private final Paint mPaintScreen;   //используется для вывода Bitmap на экран
    private final Paint mPaintLine;     //используется для рисования линий на Bitmap

    //данные нарисованных контуров Path и содержащихся в них точек
    private final Map<Integer, Path> mPathMap = new HashMap<>();
    private final Map<Integer, Point> mPreviousPointMap = new HashMap<>();


    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaintScreen = new Paint();
        //исходные параметры рисуемых линий
        mPaintLine = new Paint();
        mPaintLine.setAntiAlias(true);              //сглаживаем края
        mPaintLine.setColor(Color.BLACK);            //задаём цвет линии
        mPaintLine.setStyle(Paint.Style.STROKE);    //задаём стиль линии - сплошная
        mPaintLine.setStrokeWidth(200);             //толшщина линии
        mPaintLine.setStrokeCap(Paint.Cap.ROUND);   //закругляем линию на концах
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        mBitmapCanvas = new Canvas(mBitmap);
        mBitmap.eraseColor(Color.WHITE); //Bitmap стирается белым цветом
    }

    //стирание рисунка
    public void clear() {
        mPathMap.clear();                   //удаляем все контуры
        mPreviousPointMap.clear();          //удаляем все предыдущие точки
        mBitmap.eraseColor(Color.WHITE);    //очищаем изображения
        invalidate();                       //перерисовываем изображение
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //перерисовываем фон
        canvas.drawBitmap(mBitmap, 0, 0, mPaintScreen);

        for (Integer key : mPathMap.keySet()) {
            canvas.drawPath(mPathMap.get(key), mPaintLine); //рисуем линии
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();       //тип события
        int actionIndex = event.getActionIndex();   //указатель (курсор, палец)

        if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_POINTER_DOWN) {
            touchStarted(event.getX(actionIndex), event.getY(actionIndex), event.getPointerId(actionIndex));
        } else if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_POINTER_UP) {
            touchEnded(event.getPointerId(actionIndex));
        } else {
            touchMoved(event);
        }
        invalidate(); //перерисовываем
        return true;
    }

    //вызывается при касании экрана
    private void touchStarted(float x, float y, int lineId) {
        Path path;      //контур с заданным идентификатором
        Point point;    //последняя точка в контуре

        if (mPathMap.containsKey(lineId)) {
            path = mPathMap.get(lineId);    //получаем Path
            path.reset();                   //очищаем Path с началом нового касания
            point = mPreviousPointMap.get(lineId); //последняя точка Path

        } else {
            path = new Path();
            mPathMap.put(lineId, path);             //добавляем Path в Map
            point = new Point();                    //создаём новый объект Point
            mPreviousPointMap.put(lineId, point);   //добавляем Point в Map
        }
        //переход к координатам касания
        path.moveTo(x, y);
        point.x = (int) x;
        point.y = (int) y;
    }

    //вызывается при перемещении пальца по экрану
    private void touchMoved(MotionEvent event) {
        //для каждого курсора (пальца) в объекте MotionEvent
        for (int i = 0; i < event.getPointerCount() ; i++) {
            //получаем идентификатор и индекс указателя
            int pointerId = event.getPointerId(i);
            int pointerIndex = event.findPointerIndex(pointerId);
            //если существует объект Path, связанный с указателем
            if (mPathMap.containsKey(pointerId)) {
                //получаем новые координаты для указателя
                float newX = event.getX(pointerIndex);
                float newY = event.getY(pointerIndex);
                //получаем объект Path и предыдущий объект Point, связанный с указателем
                Path path = mPathMap.get(pointerId);
                Point point = mPreviousPointMap.get(pointerId);
                //вычисляем величину смещения от последнего обновления
                float deltaX = Math.abs(newX - point.x);
                float deltaY = Math.abs(newY - point.y);
                //если расстояние достаточно велико
                if (deltaX >= TOUCH_TOLERANCE || deltaY >= TOUCH_TOLERANCE) {
                    //расширяем контур до новой точки
                    path.quadTo(point.x, point.y, (newX + point.x) / 2, (newY + point.y) / 2);
                    //сохраненяем новые координаты
                    point.x = (int) newX;
                    point.y = (int) newY;
                }
            }
        }
    }

    //вызывается при завершении касания
    private void touchEnded(int lineId) {
        Path path = mPathMap.get(lineId);           //получаем объект Path
        mBitmapCanvas.drawPath(path, mPaintLine);   //рисуем на mBitmapCanvas
        path.reset();                               //сброс объекта Path

//        compressBitmap();
//
//        ByteBuffer buffer = ByteBuffer.allocate(mBitmap.getByteCount());
//        mBitmap.copyPixelsToBuffer(buffer);
//        byte[] bytes = buffer.array();
//
//        Float[] list = new Float[bytes.length / 4];
//        for (int i = 0; i < bytes.length / 4; i++) {
//            int j = 4 * i;
//            byte byte0 = (bytes[j + 0] < 0) ? (byte) (bytes[j + 0] + 256) : bytes[j + 0];
//            byte byte1 = (bytes[j + 1] < 0) ? (byte) (bytes[j + 1] + 256) : bytes[j + 1];
//            byte byte2 = (bytes[j + 2] < 0) ? (byte) (bytes[j + 2] + 256) : bytes[j + 2];
//            list[i] = ((float) (byte0 + byte1 + byte2) != 0.0F) ? 1.0F : 0.0F;
//
//        }
//        Log.e("TAG", "" + list.length);
//
//        for (int i = 0; i < list.length; i++) {
//            Log.e("(" + i + ")", "" + list[i]);
//        }


//        Perceptron perceptron = new Perceptron(list);

    }

    private void compressBitmap() {
        //вычисляем ширину и высоту изображения
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();

        int halfWidth = width / 100;
        int halfHeight = height / 100;

        //сжимаем картинку
        mBitmap = Bitmap.createScaledBitmap(mBitmap, halfWidth, halfHeight, false);
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public Double[] getCompressBitmap() {
        compressBitmap();

        ByteBuffer buffer = ByteBuffer.allocate(mBitmap.getByteCount());
        mBitmap.copyPixelsToBuffer(buffer);
        byte[] bytes = buffer.array();

        Double[] list = new Double[bytes.length / 4];
        for (int i = 0; i < bytes.length / 4; i++) {
            int j = 4 * i;
            byte byte0 = (bytes[j + 0] < 0) ? (byte) (bytes[j + 0] + 256) : bytes[j + 0];
            byte byte1 = (bytes[j + 1] < 0) ? (byte) (bytes[j + 1] + 256) : bytes[j + 1];
            byte byte2 = (bytes[j + 2] < 0) ? (byte) (bytes[j + 2] + 256) : bytes[j + 2];
            list[i] = ((byte0 + byte1 + byte2) != 0.0) ? 1.0 : 0.0;

        }
        Log.e("TAG", "" + list.length);
//
//        for (int i = 0; i < list.length; i++) {
//            Log.e("(" + i + ")", "" + list[i]);
//        }

        return list;
    }

    public void setBitmap(Bitmap bitmap) {
        mBitmap = bitmap;
    }

    //сохранение текущего изображения в галерее
    public void saveImage() {
        //TODO: сделать сохранение
    }
}
